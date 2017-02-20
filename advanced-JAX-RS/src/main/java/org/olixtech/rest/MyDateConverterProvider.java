package org.olixtech.rest;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Calendar;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;

@Provider
public class MyDateConverterProvider implements ParamConverterProvider {
	@Override
	public <T> ParamConverter<T> getConverter(final Class<T> rawType, Type genericType, Annotation[] annotations){
		if(rawType.getName().equals(MyDate.class.getName())){
			// Create and return a new param converter
			return new ParamConverter<T>(){
				@Override
				public T fromString(String value){
					Calendar requestedDate = Calendar.getInstance();
					if("tomorrow".equals(value.toLowerCase())){
						requestedDate.add(Calendar.DATE,1);
					}
					else if("yesterday".equals(value.toLowerCase())){
						requestedDate.add(Calendar.DATE,-1);
					}
					
					MyDate myDate = new MyDate();
					myDate.setDate(requestedDate.get(Calendar.DATE));
					myDate.setMonth(requestedDate.get(Calendar.MONTH) + 1);	// Adding 1 because the calendar month is zero based
					myDate.setYear(requestedDate.get(Calendar.YEAR));
					
					return rawType.cast(myDate);
				}
				
				@Override
				public String toString(T myBean){
					if( myBean == null){
						return null;
					}
					else{
						return myBean.toString();
					}
				}
			};
		}
		return null;
	}
}
