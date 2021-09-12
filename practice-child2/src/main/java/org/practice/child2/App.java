package org.practice.child2;

import org.apache.commons.lang3.StringUtils;

import com.practice.DateGenerator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( 
        		StringUtils.capitalize("Hello World!" + " Date is : " + new DateGenerator().getDate())
        		);
    }
}
