package org.loan;

import java.io.IOException;

import tech.tablesaw.api.NumericColumn;
import tech.tablesaw.api.StringColumn;
import tech.tablesaw.api.ColumnType;
import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.Table;
import tech.tablesaw.plotly.Plot;
import tech.tablesaw.plotly.components.Figure;
import tech.tablesaw.plotly.components.Layout;
import tech.tablesaw.plotly.traces.BoxTrace;
import tech.tablesaw.plotly.traces.HistogramTrace;
import tech.tablesaw.plotly.traces.PieTrace;
import tech.tablesaw.plotly.traces.ScatterTrace;
import tech.tablesaw.plotly.traces.HeatmapTrace;
import weka.core.converters.ConverterUtils.DataSource;
import tech.tablesaw.aggregate.CrossTab;
import tech.tablesaw.aggregate.CrossTab.*;
import tech.tablesaw.plotly.components.Layout.LayoutBuilder;
import tech.tablesaw.api.StringColumn.*;
import tech.tablesaw.api.IntColumn;
import tech.tablesaw.api.BooleanColumn.*;
import tech.tablesaw.columns.numbers.NumberFilters;
import tech.tablesaw.columns.strings.StringFilters;
import tech.tablesaw.columns.Column;
import tech.tablesaw.columns.booleans.BooleanFilters;
import tech.tablesaw.selection.*;
import tech.tablesaw.api.CategoricalColumn;
import tech.tablesaw.table.Relation.*;
import tech.tablesaw.table.TableSliceGroup;
public class DataAnalysis {
	
	public static void main(String args[])
	{
		System.out.println("data Analysis");
		
		try {
			
//TRAINING DATA
			Table train_u6lujuX_CVtuZ9i = Table.read().csv("C:\\Users\\dhondik\\eclipse-workspace\\org.we\\src\\main\\java\\org\\we\\train_u6lujuX_CVtuZ9i.csv");
		 
			System.out.println(train_u6lujuX_CVtuZ9i.shape());
			System.out.println(train_u6lujuX_CVtuZ9i.structure());
			System.out.println(train_u6lujuX_CVtuZ9i.summary());
//Data Pre-processing			
			
     //Finding the the Missing data (Mean,Mode & Medium)
			
			System.out.println("******Data Preprocessing with Train data******");
			System.out.println(train_u6lujuX_CVtuZ9i.missingValueCounts());
		
			System.out.println(train_u6lujuX_CVtuZ9i.categoricalColumn("Gender").countByCategory());
			System.out.println(train_u6lujuX_CVtuZ9i.stringColumn("Gender").setMissingTo("Male"));
			System.out.println(train_u6lujuX_CVtuZ9i.categoricalColumn("Gender").countByCategory());
			
			System.out.println(train_u6lujuX_CVtuZ9i.categoricalColumn("Married").countByCategory());
			System.out.println(train_u6lujuX_CVtuZ9i.stringColumn("Married").setMissingTo("Yes"));
			System.out.println(train_u6lujuX_CVtuZ9i.categoricalColumn("Married").countByCategory());
			
			System.out.println(train_u6lujuX_CVtuZ9i.categoricalColumn("Dependents").countByCategory());
			System.out.println(train_u6lujuX_CVtuZ9i.stringColumn("Dependents").setMissingTo("0"));
			System.out.println(train_u6lujuX_CVtuZ9i.categoricalColumn("Dependents").countByCategory());
			
			System.out.println(train_u6lujuX_CVtuZ9i.categoricalColumn("Self_Employed").countByCategory());
			System.out.println(train_u6lujuX_CVtuZ9i.stringColumn("Self_Employed").setMissingTo("No"));
			System.out.println(train_u6lujuX_CVtuZ9i.categoricalColumn("Self_Employed").countByCategory());
		   
			System.out.println(train_u6lujuX_CVtuZ9i.categoricalColumn("Loan_Amount_Term").countByCategory());
			System.out.println(train_u6lujuX_CVtuZ9i.intColumn("Loan_Amount_Term").setMissingTo(360));
			System.out.println(train_u6lujuX_CVtuZ9i.categoricalColumn("Loan_Amount_Term").countByCategory());
			
			System.out.println(train_u6lujuX_CVtuZ9i.categoricalColumn("Credit_History").countByCategory());
			System.out.println(train_u6lujuX_CVtuZ9i.intColumn("Credit_History").setMissingTo(1));
			System.out.println(train_u6lujuX_CVtuZ9i.categoricalColumn("Credit_History").countByCategory());
			
			System.out.println("Mean of LoanAmount:"+train_u6lujuX_CVtuZ9i.intColumn("LoanAmount").mean());
			System.out.println(train_u6lujuX_CVtuZ9i.categoricalColumn("LoanAmount").countByCategory());
			System.out.println(train_u6lujuX_CVtuZ9i.intColumn("LoanAmount").setMissingTo(146));
			System.out.println(train_u6lujuX_CVtuZ9i.categoricalColumn("LoanAmount").countByCategory());
			
			System.out.println(train_u6lujuX_CVtuZ9i.missingValueCounts());
			//replace 
			((StringFilters)train_u6lujuX_CVtuZ9i.categoricalColumn("Dependents")).set(((StringFilters) train_u6lujuX_CVtuZ9i.categoricalColumn("Dependents")).isEqualTo("3+"),"3");
			System.out.println("After replacement:"+train_u6lujuX_CVtuZ9i.categoricalColumn("Dependents").countByCategory());
				
			//Update file
				 
				train_u6lujuX_CVtuZ9i.write().csv("train_u6lujuX_CVtuZ9i-updated.csv");
		
				
				
//TESTING DATA	
				System.out.println("******Data Preprocessing With Test Data******");
				Table test_Y3wMUE5_7gLdaTN = Table.read().csv("C:\\Users\\dhondik\\eclipse-workspace\\org.we\\src\\main\\java\\org\\we\\test_Y3wMUE5_7gLdaTN.csv");
				  
				System.out.println(test_Y3wMUE5_7gLdaTN.shape());
				System.out.println(test_Y3wMUE5_7gLdaTN.structure());
				System.out.println(test_Y3wMUE5_7gLdaTN.summary());
				
				System.out.println(test_Y3wMUE5_7gLdaTN.missingValueCounts());
				
			    System.out.println(test_Y3wMUE5_7gLdaTN.categoricalColumn("Gender").countByCategory());
				System.out.println(test_Y3wMUE5_7gLdaTN.stringColumn("Gender").setMissingTo("Male"));
				System.out.println(test_Y3wMUE5_7gLdaTN.categoricalColumn("Gender").countByCategory());
				
				System.out.println(test_Y3wMUE5_7gLdaTN.categoricalColumn("Dependents").countByCategory());
				System.out.println(test_Y3wMUE5_7gLdaTN.stringColumn("Dependents").setMissingTo("0"));
				System.out.println(test_Y3wMUE5_7gLdaTN.categoricalColumn("Dependents").countByCategory());
				
				System.out.println(test_Y3wMUE5_7gLdaTN.categoricalColumn("Self_Employed").countByCategory());
				System.out.println(test_Y3wMUE5_7gLdaTN.stringColumn("Self_Employed").setMissingTo("No"));
				System.out.println(test_Y3wMUE5_7gLdaTN.categoricalColumn("Self_Employed").countByCategory());
			   
				System.out.println(test_Y3wMUE5_7gLdaTN.categoricalColumn("Loan_Amount_Term").countByCategory());
				System.out.println(test_Y3wMUE5_7gLdaTN.intColumn("Loan_Amount_Term").setMissingTo(360));
				System.out.println(test_Y3wMUE5_7gLdaTN.categoricalColumn("Loan_Amount_Term").countByCategory());
				
				System.out.println(test_Y3wMUE5_7gLdaTN.categoricalColumn("Credit_History").countByCategory());
				System.out.println(test_Y3wMUE5_7gLdaTN.intColumn("Credit_History").setMissingTo(1));
				System.out.println(test_Y3wMUE5_7gLdaTN.categoricalColumn("Credit_History").countByCategory());
				
				System.out.println("Mean of LoanAmount:"+test_Y3wMUE5_7gLdaTN.intColumn("LoanAmount").mean());
				System.out.println(test_Y3wMUE5_7gLdaTN.categoricalColumn("LoanAmount").countByCategory());
				System.out.println(test_Y3wMUE5_7gLdaTN.intColumn("LoanAmount").setMissingTo(136));
				System.out.println(test_Y3wMUE5_7gLdaTN.categoricalColumn("LoanAmount").countByCategory());
				
				System.out.println(test_Y3wMUE5_7gLdaTN.missingValueCounts());
				
				
				
				test_Y3wMUE5_7gLdaTN= test_Y3wMUE5_7gLdaTN.dropDuplicateRows();
				test_Y3wMUE5_7gLdaTN.dropRowsWithMissingValues();
				System.out.println(test_Y3wMUE5_7gLdaTN.shape());
				//replace 
				((StringFilters)test_Y3wMUE5_7gLdaTN.categoricalColumn("Dependents")).set(((StringFilters) test_Y3wMUE5_7gLdaTN.categoricalColumn("Dependents")).isEqualTo("3+"),"3");
				System.out.println("After replacement:"+test_Y3wMUE5_7gLdaTN.categoricalColumn("Dependents").countByCategory());
			//update file 	
				
				test_Y3wMUE5_7gLdaTN.write().csv("test_Y3wMUE5_7gLdaTN-updated.csv");
//CrossTab
				System.out.println(CrossTab.counts(train_u6lujuX_CVtuZ9i,train_u6lujuX_CVtuZ9i.stringColumn("Gender"),train_u6lujuX_CVtuZ9i.intColumn("LoanAmount")).first(10));
			
				
//DATA VISUALIZATION				
	//HistogramTrace
			 Layout layout1 = Layout.builder().title("Distribution of  Loan_ID").build();
			 HistogramTrace trace1 = HistogramTrace.builder(train_u6lujuX_CVtuZ9i.nCol("Loan_ID")).build();
			 Plot.show(new Figure(layout1, trace1));
		    
		    Layout layout2 = Layout.builder().title("Distribution of  Gender").build();
		    HistogramTrace trace2 = HistogramTrace.builder(train_u6lujuX_CVtuZ9i.nCol("Gender")).build();
		    Plot.show(new Figure(layout2, trace2));
		    
		    Layout layout3 = Layout.builder().title("Distribution of  Married").build();
		    HistogramTrace trace3 = HistogramTrace.builder(train_u6lujuX_CVtuZ9i.nCol("Married")).build();
		    Plot.show(new Figure(layout3, trace3));
		   
		    Layout layout4 = Layout.builder().title("Distribution of  Dependents").build();
		    HistogramTrace trace4 = HistogramTrace.builder(train_u6lujuX_CVtuZ9i.nCol("Dependents")).build();
		    Plot.show(new Figure(layout4, trace4));
		    
		    Layout layout5 = Layout.builder().title("Distribution of  Education").build();
		    HistogramTrace trace5 = HistogramTrace.builder(train_u6lujuX_CVtuZ9i.nCol("Education")).build();
		    Plot.show(new Figure(layout5, trace5));
		    
		    Layout layout6 = Layout.builder().title("Distribution of  Self_Employed").build();
		    HistogramTrace trace6 = HistogramTrace.builder(train_u6lujuX_CVtuZ9i.nCol("Self_Employed")).build();
		    Plot.show(new Figure(layout6, trace6));
		    
		    Layout layout7 = Layout.builder().title("Distribution of  ApplicantIncome").build();
		    HistogramTrace trace7 = HistogramTrace.builder(train_u6lujuX_CVtuZ9i.nCol("ApplicantIncome")).build();
		    Plot.show(new Figure(layout7, trace7));
		    
		    Layout layout8 = Layout.builder().title("Distribution of CoapplicantIncome ").build();
		    HistogramTrace trace8 = HistogramTrace.builder(train_u6lujuX_CVtuZ9i.nCol("CoapplicantIncome")).build();
		    Plot.show(new Figure(layout8, trace8));
		    
		    Layout layout9 = Layout.builder().title("Distribution of LoanAmount ").build();
		    HistogramTrace trace9 = HistogramTrace.builder(train_u6lujuX_CVtuZ9i.nCol("LoanAmount")).build();
		    Plot.show(new Figure(layout9, trace9));
		    
		    Layout layout10 = Layout.builder().title("Distribution of Loan_Amount_Term").build();
		    HistogramTrace trace10 = HistogramTrace.builder(train_u6lujuX_CVtuZ9i.nCol("Loan_Amount_Term")).build();
		    Plot.show(new Figure(layout10, trace10));
		    
    	    Layout layout11 = Layout.builder().title("Distribution of  Credit_History").build();
		    HistogramTrace trace11 = HistogramTrace.builder(train_u6lujuX_CVtuZ9i.nCol("Credit_History")).build();
		    Plot.show(new Figure(layout11, trace11));
		    
		    Layout layout12 = Layout.builder().title("Distribution of  Property_Area").build();
		    HistogramTrace trace12 = HistogramTrace.builder(train_u6lujuX_CVtuZ9i.nCol("Property_Area")).build();
		    Plot.show(new Figure(layout12, trace12));
		    
		    Layout layout13 = Layout.builder().title("Distribution of  Loan_Status").build();
		    HistogramTrace trace13 = HistogramTrace.builder(train_u6lujuX_CVtuZ9i.nCol("Property_Area")).build();
		    Plot.show(new Figure(layout13, trace13));
	//BoxTrace  
	       Layout layout14 = Layout.builder().title("Loan_Status with Loan_Id").build();
		    BoxTrace trace14 =BoxTrace.builder(train_u6lujuX_CVtuZ9i.categoricalColumn("Loan_Status"), train_u6lujuX_CVtuZ9i.nCol("Loan_ID")).build();
		    Plot.show(new Figure(layout14, trace14));
			
		    Layout layout15 = Layout.builder().title("Loan_Status with Gender").build();
		    BoxTrace trace15 =BoxTrace.builder(train_u6lujuX_CVtuZ9i.categoricalColumn("Married"), train_u6lujuX_CVtuZ9i.nCol("Gender")).build();
		    Plot.show(new Figure(layout15, trace15));
		    
		    Layout layout16 = Layout.builder().title("Dependents with Married").build();
		    BoxTrace trace16 =BoxTrace.builder(train_u6lujuX_CVtuZ9i.categoricalColumn("Dependents"), train_u6lujuX_CVtuZ9i.nCol("Married")).build();
		    Plot.show(new Figure(layout16, trace16));
		    
		    Layout layout17 = Layout.builder().title("Education with Dependents").build();
		    BoxTrace trace17 =BoxTrace.builder(train_u6lujuX_CVtuZ9i.categoricalColumn("Education"), train_u6lujuX_CVtuZ9i.nCol("Dependents")).build();
		    Plot.show(new Figure(layout17, trace17));
		  
		    Layout layout18 = Layout.builder().title("Self_Employed with Education").build();
		    BoxTrace trace18 =BoxTrace.builder(train_u6lujuX_CVtuZ9i.categoricalColumn("Self_Employed"), train_u6lujuX_CVtuZ9i.nCol("Education")).build();
		    Plot.show(new Figure(layout18, trace18));
		    
		    Layout layout19 = Layout.builder().title("ApplicantIncome with Self_Employed").build();
		    BoxTrace trace19 =BoxTrace.builder(train_u6lujuX_CVtuZ9i.categoricalColumn("ApplicantIncome"), train_u6lujuX_CVtuZ9i.nCol("Self_Employed")).build();
		    Plot.show(new Figure(layout19, trace19));
		    
		    Layout layout21 = Layout.builder().title("LoanAmount with ApplicantIncome ").build();
		    BoxTrace trace21 =BoxTrace.builder(train_u6lujuX_CVtuZ9i.categoricalColumn("LoanAmount"), train_u6lujuX_CVtuZ9i.nCol("ApplicantIncome")).build();
		    Plot.show(new Figure(layout21, trace21));
		    
		    Layout layout22 = Layout.builder().title("ApplicantIncome with CoapplicantIncome ").build();
		    BoxTrace trace22 =BoxTrace.builder(train_u6lujuX_CVtuZ9i.categoricalColumn("ApplicantIncome"), train_u6lujuX_CVtuZ9i.nCol("CoapplicantIncome")).build();
		    Plot.show(new Figure(layout22, trace22));
		    
		    Layout layout23 = Layout.builder().title("LoanAmount with CoapplicantIncome ").build();
		    BoxTrace trace23 =BoxTrace.builder(train_u6lujuX_CVtuZ9i.categoricalColumn("LoanAmount"), train_u6lujuX_CVtuZ9i.nCol("CoapplicantIncome")).build();
		    Plot.show(new Figure(layout23, trace23));
		    
		    Layout layout24 = Layout.builder().title("Loan_Status with LoanAmount ").build();
		    BoxTrace trace24 =BoxTrace.builder(train_u6lujuX_CVtuZ9i.categoricalColumn("Loan_Amount_Term"), train_u6lujuX_CVtuZ9i.nCol("LoanAmount")).build();
		    Plot.show(new Figure(layout24, trace24));
		    
		    Layout layout25 = Layout.builder().title("Credit_History with Loan_Amount_Term ").build();
		    BoxTrace trace25 =BoxTrace.builder(train_u6lujuX_CVtuZ9i.categoricalColumn("Credit_History"), train_u6lujuX_CVtuZ9i.nCol("Loan_Amount_Term")).build();
		    Plot.show(new Figure(layout25, trace25));
		    
		    Layout layout26 = Layout.builder().title("Property_Area with Credit_History ").build();
		    BoxTrace trace26 =BoxTrace.builder(train_u6lujuX_CVtuZ9i.categoricalColumn("Property_Area"), train_u6lujuX_CVtuZ9i.nCol("Credit_History")).build();
		    Plot.show(new Figure(layout26, trace26));
		    
		    Layout layout27 = Layout.builder().title("Loan_Status with Property_Area").build();
		    BoxTrace trace27 =BoxTrace.builder(train_u6lujuX_CVtuZ9i.categoricalColumn("Loan_Status"), train_u6lujuX_CVtuZ9i.nCol("Property_Area")).build();
		    Plot.show(new Figure(layout27, trace27));
	// ScatterTrace
		    Layout layout28 = Layout.builder().title("Gender with Loan_Id").build();
		    ScatterTrace trace28 =ScatterTrace.builder(train_u6lujuX_CVtuZ9i.categoricalColumn("Gender"), train_u6lujuX_CVtuZ9i.nCol("Loan_ID")).build();
		    Plot.show(new Figure(layout28, trace28));
			
		    Layout layout29 = Layout.builder().title("Married with Gender").build();
		    ScatterTrace trace29 =ScatterTrace.builder(train_u6lujuX_CVtuZ9i.categoricalColumn("Married"), train_u6lujuX_CVtuZ9i.nCol("Gender")).build();
		    Plot.show(new Figure(layout29, trace29));
		    
		    Layout layout30 = Layout.builder().title("Dependents with Married").build();
		    ScatterTrace trace30 =ScatterTrace.builder(train_u6lujuX_CVtuZ9i.categoricalColumn("Dependents"), train_u6lujuX_CVtuZ9i.nCol("Married")).build();
		    Plot.show(new Figure(layout30, trace30));
		    
		    Layout layout31 = Layout.builder().title("Education with Dependents").build();
		    ScatterTrace trace31 =ScatterTrace.builder(train_u6lujuX_CVtuZ9i.categoricalColumn("Education"), train_u6lujuX_CVtuZ9i.nCol("Dependents")).build();
		    Plot.show(new Figure(layout31, trace31));
		  
		    Layout layout32 = Layout.builder().title("Self_Employed with Education").build();
		    ScatterTrace trace32 =ScatterTrace.builder(train_u6lujuX_CVtuZ9i.categoricalColumn("Self_Employed"), train_u6lujuX_CVtuZ9i.nCol("Education")).build();
		    Plot.show(new Figure(layout32, trace32));
		    
		    Layout layout33 = Layout.builder().title("ApplicantIncome with Self_Employed").build();
		    ScatterTrace trace33 =ScatterTrace.builder(train_u6lujuX_CVtuZ9i.categoricalColumn("ApplicantIncome"), train_u6lujuX_CVtuZ9i.nCol("Self_Employed")).build();
		    Plot.show(new Figure(layout33, trace33));
		    
		    Layout layout34 = Layout.builder().title("CoapplicantIncome with ApplicantIncome ").build();
		    ScatterTrace trace34 =ScatterTrace.builder(train_u6lujuX_CVtuZ9i.categoricalColumn("LoanAmount"), train_u6lujuX_CVtuZ9i.nCol("ApplicantIncome")).build();
		    Plot.show(new Figure(layout34, trace34));
		    
		    Layout layout35 = Layout.builder().title("Loan_Status with CoapplicantIncome ").build();
		    ScatterTrace trace35 =ScatterTrace.builder(train_u6lujuX_CVtuZ9i.categoricalColumn("Loan_Status"), train_u6lujuX_CVtuZ9i.nCol("CoapplicantIncome")).build();
		    Plot.show(new Figure(layout35, trace35));
		    
		    Layout layout36 = Layout.builder().title("LoanAmount with CoapplicantIncome ").build();
		    ScatterTrace trace36 =ScatterTrace.builder(train_u6lujuX_CVtuZ9i.categoricalColumn("LoanAmount"), train_u6lujuX_CVtuZ9i.nCol("CoapplicantIncome")).build();
		    Plot.show(new Figure(layout36, trace36));
		    
		    Layout layout37 = Layout.builder().title("Loan_Amount_Term with LoanAmount ").build();
		    ScatterTrace trace37 =ScatterTrace.builder(train_u6lujuX_CVtuZ9i.categoricalColumn("Loan_Amount_Term"), train_u6lujuX_CVtuZ9i.nCol("LoanAmount")).build();
		    Plot.show(new Figure(layout37, trace37));
		    
		    Layout layout38 = Layout.builder().title("Credit_History with Loan_Amount_Term ").build();
		    ScatterTrace trace38 =ScatterTrace.builder(train_u6lujuX_CVtuZ9i.categoricalColumn("Credit_History"), train_u6lujuX_CVtuZ9i.nCol("Loan_Amount_Term")).build();
		    Plot.show(new Figure(layout38, trace38));
		    
		    Layout layout39 = Layout.builder().title("Property_Area with Credit_History ").build();
		    ScatterTrace trace39 =ScatterTrace.builder(train_u6lujuX_CVtuZ9i.categoricalColumn("Property_Area"), train_u6lujuX_CVtuZ9i.nCol("Credit_History")).build();
		    Plot.show(new Figure(layout39, trace39));
		    
		    Layout layout40 = Layout.builder().title("Loan_Status with Property_Area").build();
		    ScatterTrace trace40 =ScatterTrace.builder(train_u6lujuX_CVtuZ9i.categoricalColumn("Loan_Status"), train_u6lujuX_CVtuZ9i.nCol("Property_Area")).build();
		    Plot.show(new Figure(layout40, trace40));
	//PieTrace
		    Layout layout41 = Layout.builder().title("Loan_Status with Loan_Id").build();
		    PieTrace trace41 =PieTrace.builder(train_u6lujuX_CVtuZ9i.categoricalColumn("Loan_Status"), train_u6lujuX_CVtuZ9i.nCol("Loan_ID")).build();
		    Plot.show(new Figure(layout41, trace41));
			
		    Layout layout42 = Layout.builder().title("Loan_Status with Gender").build();
		    PieTrace trace42 =PieTrace.builder(train_u6lujuX_CVtuZ9i.categoricalColumn("Loan_Status"), train_u6lujuX_CVtuZ9i.nCol("Gender")).build();
		    Plot.show(new Figure(layout42, trace42));
		    
		    Layout layout43 = Layout.builder().title("Education with Married").build();
		    PieTrace trace43 =PieTrace.builder(train_u6lujuX_CVtuZ9i.categoricalColumn("Education"), train_u6lujuX_CVtuZ9i.nCol("Married")).build();
		    Plot.show(new Figure(layout43, trace43));
		    
		    Layout layout44 = Layout.builder().title("Loan_Status with Dependents").build();
		    PieTrace trace44 =PieTrace.builder(train_u6lujuX_CVtuZ9i.categoricalColumn("Loan_Status"), train_u6lujuX_CVtuZ9i.nCol("Dependents")).build();
		    Plot.show(new Figure(layout44, trace44));
		  
		    Layout layout45 = Layout.builder().title("Dependents with Education").build();
		    PieTrace trace45 =PieTrace.builder(train_u6lujuX_CVtuZ9i.categoricalColumn("Dependents"), train_u6lujuX_CVtuZ9i.nCol("Education")).build();
		    Plot.show(new Figure(layout45, trace45));
		    
		    Layout layout46 = Layout.builder().title("Loan_Status with Self_Employed").build();
		    PieTrace trace46 =PieTrace.builder(train_u6lujuX_CVtuZ9i.categoricalColumn("Loan_Status"), train_u6lujuX_CVtuZ9i.nCol("Self_Employed")).build();
		    Plot.show(new Figure(layout46, trace46));
		    
		    Layout layout47 = Layout.builder().title("Education with ApplicantIncome ").build();
		    PieTrace trace47 =PieTrace.builder(train_u6lujuX_CVtuZ9i.categoricalColumn("Education"), train_u6lujuX_CVtuZ9i.nCol("ApplicantIncome")).build();
		    Plot.show(new Figure(layout47, trace47));
		    
		    Layout layout48 = Layout.builder().title("Self_Employed with CoapplicantIncome ").build();
		    PieTrace trace48 =PieTrace.builder(train_u6lujuX_CVtuZ9i.categoricalColumn("Self_Employed"), train_u6lujuX_CVtuZ9i.nCol("CoapplicantIncome")).build();
		    Plot.show(new Figure(layout48, trace48));
		    
		    Layout layout49 = Layout.builder().title("Married with CoapplicantIncome ").build();
		    PieTrace trace49 =PieTrace.builder(train_u6lujuX_CVtuZ9i.categoricalColumn("Married"), train_u6lujuX_CVtuZ9i.nCol("CoapplicantIncome")).build();
		    Plot.show(new Figure(layout49, trace49));
		    
		    Layout layout50 = Layout.builder().title("Loan_Status with LoanAmount ").build();
		    PieTrace trace50 =PieTrace.builder(train_u6lujuX_CVtuZ9i.categoricalColumn("Loan_Status"), train_u6lujuX_CVtuZ9i.nCol("LoanAmount")).build();
		    Plot.show(new Figure(layout50, trace50));
		    
		    Layout layout51 = Layout.builder().title("Property_Area with Loan_Amount_Term ").build();
		    PieTrace trace51 =PieTrace.builder(train_u6lujuX_CVtuZ9i.categoricalColumn("Property_Area"), train_u6lujuX_CVtuZ9i.nCol("Loan_Amount_Term")).build();
		    Plot.show(new Figure(layout51, trace51));
		    
		    Layout layout52 = Layout.builder().title("LoanAmount with Credit_History ").build();
		    PieTrace trace52 =PieTrace.builder(train_u6lujuX_CVtuZ9i.categoricalColumn("LoanAmount"), train_u6lujuX_CVtuZ9i.nCol("Credit_History")).build();
		    Plot.show(new Figure(layout52, trace52));
		    
		    Layout layout53 = Layout.builder().title("Loan_Status with Property_Area").build();
		    PieTrace trace53 =PieTrace.builder(train_u6lujuX_CVtuZ9i.categoricalColumn("Gender"), train_u6lujuX_CVtuZ9i.nCol("Property_Area")).build();
		    Plot.show(new Figure(layout53, trace53));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}