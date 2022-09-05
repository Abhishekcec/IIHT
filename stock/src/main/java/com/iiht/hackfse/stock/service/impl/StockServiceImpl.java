package com.iiht.hackfse.stock.service.impl;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;
import com.iiht.hackfse.stock.model.Stock;
import com.iiht.hackfse.stock.repository.StockRepository;
import com.iiht.hackfse.stock.service.StockService;
import com.iiht.hackfse.stock.transformer.StockDetails;

@Service
public class StockServiceImpl implements StockService{
	
	@Autowired
	private StockRepository stockRepository;
	
	@Autowired
    private AmazonSNSClient amazonSNSClient;

    private String TOPIC_ARN = "arn:aws:sns:us-east-1:358497785510:iiht-topic";


	@Override
	public Stock saveStock(Stock stock) {
		// TODO Auto-generated method stub
		LocalDateTime now = LocalDateTime.now();
		stock.setDate(now);
		System.out.println(stock.toString());
//		publishToTopic(stock.toString());
		return stockRepository.save(stock);
	}
	
	public String subscribeToSNSTopic( String email) {
        SubscribeRequest subscribeRequest =
                new SubscribeRequest(TOPIC_ARN,"email",email);

        amazonSNSClient.subscribe(subscribeRequest);
        return "Check your Email 🙏";
    }

   
    public String publishToTopic(String msg){
        PublishRequest publishRequest =
                new PublishRequest(TOPIC_ARN,msg,"SNS SpringBoot" );

        amazonSNSClient.publish(publishRequest);
        return "Message Published!";
    }
	@Override
	public StockDetails getCompanyStockPrice(LocalDateTime startDate, LocalDateTime endDate, String companyCode) {
		List<Stock> stocks = stockRepository.findByCompanyCode(companyCode);
		if(stocks!=null && stocks.size()>0) {
			List<Stock> filteredStocks = new ArrayList<>();
			Double sum =0D;
			Double max= 0D;
			Double min = Double.MAX_VALUE;
			for(Stock stock : stocks) {
				if(stock.getDate().isAfter(startDate) && stock.getDate().isBefore(endDate)) {
					
					filteredStocks.add(stock);
					if(stock.getPrice()> max)
					{
						max=stock.getPrice();
					}
					if(stock.getPrice() < min)
					{
						min = stock.getPrice();
					}
					
					sum=sum+stock.getPrice();
					
				}
			}
			Double average = sum/filteredStocks.size();
			if(filteredStocks.size()>0) {
				return new StockDetails(filteredStocks,min,max,average);
			}else {
				return new StockDetails();
			}
			
			
		}else {
			return new StockDetails();
		}
	}

	@Override
	public StockDetails getStocksByCompanyCode(String companyCode) {
		try {
			List<Stock> stocks = stockRepository.findByCompanyCode(companyCode);
			Double sum = 0D;
			Double max = 0D;
			Double min = Double.MAX_VALUE;
			for (Stock stock : stocks) {
					if (stock.getPrice() > max) {
						max = stock.getPrice();
					}
					if (stock.getPrice() < min) {
						min = stock.getPrice();
					}

					sum = sum + stock.getPrice();
			}
			Double average=0D;
			if(sum>0) {
			 average = sum / stocks.size();
			}
				
			if(min==Double.MAX_VALUE)
				min=0D;
			
			return new StockDetails(stocks, min, max, average);

		} catch (Exception e) {
			System.out.println("Error while fetching stocks with companycode" + e);
		}
		return null;

	}

	@Override
	public String deleteStocksByCompanyCode(String companyCode) {
		List<Stock> toBeDeletedCompany = stockRepository.findByCompanyCode(companyCode);
		if (null != toBeDeletedCompany) {
			try {
				stockRepository.deleteAll(toBeDeletedCompany);
				return "Stocks deleted Successfully";
			} catch (Exception e) {
				System.out.print("Exception in deleteCompany"+e);
				return "Something went wrong";
			}
		}else {
			return "Something went wrong-Company code does exist in DB";
		}
	}

}
