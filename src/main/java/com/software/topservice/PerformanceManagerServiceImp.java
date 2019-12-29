package com.software.topservice;

import static org.hamcrest.CoreMatchers.containsString;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.software.domain.SaleorderCommon;
import com.software.service.SaleorderCommonService;
import com.software.trans.WarehoursePerformance;

@Service
public class PerformanceManagerServiceImp implements PerformanceManagerService 
{
	@Autowired
	private SaleorderCommonService commonService;
	
	@Override
	public WarehoursePerformance calWarehoursePerformance(WarehoursePerformance record) 
	{
		// 设置时间
		String startTimeString = record.getStarttime();
		String endTimeString = record.getEndtime();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		if (startTimeString.equals("")) 
		{
			startTimeString = df.format(new Date(0));
		}
		if (endTimeString.equals("")) 
		{
			endTimeString = df.format(new Date());
		}
		Instant startTime = dateToInstant(startTimeString);
		Instant endTime = dateToInstant(endTimeString);
		Instant orderTime;
		// 读取仓库所有已付款未退货的订单数目
		SaleorderCommon exampleCommon = new SaleorderCommon();
		String tablename = "sub_saleorder_common_"+String.format("%04d", record.getWarehourseid());
		exampleCommon.setTablename(tablename);
		exampleCommon.setStatus(5);
		List<SaleorderCommon> commonList = commonService.select(exampleCommon);
		
		// 读取客户数目，订单数，利润
		Set<Integer> clientIDSet = new HashSet<Integer>();
		float sumMargin = 1.0f;
		float tempMargin;
		for (SaleorderCommon saleorderCommon : commonList) 
		{
			orderTime = dateToInstant(saleorderCommon.getGathertime());
			if (orderTime.isBefore(endTime)&&orderTime.isAfter(startTime)) 
			{
				clientIDSet.add(saleorderCommon.getClientid());
				tempMargin = saleorderCommon.getMargin();
				if (tempMargin<=0) 
				{
					tempMargin = 0.1f;
				}
				sumMargin += tempMargin;
			}
			else
			{
				continue;
			}
		}
		// 计算业绩
		float clientNum = clientIDSet.size() + 1;
		float orderNum = commonList.size()+1;
		float performance = (clientNum+orderNum)*sumMargin;
		
		WarehoursePerformance warehoursePerformance = new WarehoursePerformance();
		warehoursePerformance.setWarehourseid(record.getWarehourseid());
		warehoursePerformance.setWarehoursename(record.getWarehoursename());
		warehoursePerformance.setPrincipalid(record.getPrincipalid());
		warehoursePerformance.setPrincipalname(record.getPrincipalname());
		warehoursePerformance.setPerformancedetail(String.valueOf(performance));
		warehoursePerformance.setStarttime(startTimeString);
		warehoursePerformance.setEndtime(endTimeString);
		return warehoursePerformance;
	}

	@Override
	public List<WarehoursePerformance> calStaffPerformance(WarehoursePerformance record) 
	{
		// 设置时间
		String startTimeString = record.getStarttime();
		String endTimeString = record.getEndtime();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		if (startTimeString.equals("")) 
		{
			startTimeString = df.format(new Date(0));
		}
		if (endTimeString.equals("")) 
		{
			endTimeString = df.format(new Date());
		}
		Instant startTime = dateToInstant(startTimeString);
		Instant endTime = dateToInstant(endTimeString);
		Instant orderTime;
		
		SaleorderCommon exampleCommon = new SaleorderCommon();
		String tablename = "sub_saleorder_common_"+String.format("%04d", record.getWarehourseid());
		exampleCommon.setTablename(tablename);
		exampleCommon.setStatus(5);
		List<SaleorderCommon> commonList = commonService.select(exampleCommon);
		return null;
	}
	
	private Instant dateToInstant(String date)
	{
		String temp = date.replace(" ", "T");
		temp = temp+"Z";
		return Instant.parse(temp);
	}
	
	private String instantToDate(Instant instant)
	{
		String temp = instant.toString();
		return temp.replace("T", " ").substring(0, temp.length()-1);
	}

}
