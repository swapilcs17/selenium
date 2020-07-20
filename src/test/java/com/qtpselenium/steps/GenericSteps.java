package com.qtpselenium.steps;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import com.qtpselenium.webdriver.WebConnector;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
// pico container
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class GenericSteps<IResource> {

	WebConnector con;
	private Object ResourcesPlugin;
	
	public GenericSteps(WebConnector con) {
		this.con = con;
	}
	
	@Before
	public void before(Scenario s) {
		System.out.println("***Bef*** "+s.getName());
		con.initReports(s.getName());
	

	}	
	
	
	@After
	public void after() {
		System.out.println("***Aft***");	
		con.quit();
	}
	
	
	@Given("^I open (.*)$")
	public void openBrowser(String browserName) {		
		System.out.println("Opening Browser "+con.name);
		con.infoLog("Opening Browser "+browserName);
		con.openBrowser(browserName);
	}
	
	@And("^I go to (.*)$")
	public void navigate(String url) {
		//System.out.println("Navigating to "+ con.name);
		con.infoLog("Navigating to "+ url);
		con.navigate(url);
	}

	@And("^I type (.*) in (.*) field$")
	public void type(String data,String locatorKey) {
		con.infoLog("Typing in "+locatorKey+". Data "+data);
		con.type(locatorKey, data);
	}
	@And("^I clear (.*)$")
	public void clear(String locatorKey) {
		con.infoLog("Clearing in "+locatorKey);
		con.clear(locatorKey);
	}
	
	@And("^I click on (.*)$")
	public void click(String locatorKey) {
		con.infoLog("Clicking on "+ locatorKey);
		con.click(locatorKey);	
	}
	
	@And("^I click (.*) and wait for (.*)$")
	public void clickAndWait(String src,String target) {
		con.infoLog("Clicking on "+ src);
		con.clickAndWait(src, target, 20);	
	}
	@And("I select (.*) from (.*)")
	public void select(String data,String locatorKey) {
		con.infoLog("Selecting from "+ locatorKey);
		con.select(locatorKey,data);
	}

	@And("^I wait for page to load$")
	public void waitForPageToLoad() {
		con.waitForPageToLoad();
	}
	
	@When("^I accept alert$")
	public void iAcceptAlert() {
		con.acceptAlertIfPresent();
	}
	
}
