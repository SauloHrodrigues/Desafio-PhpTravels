package com.demoblaze.test.pages;

import static com.demoblaze.kernel.Contexto.getDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(xpath = "//a[@#exampleModal']")
	private WebElement linkContact;
	
	@FindBy(xpath = "//a[@data-target='#videoModal']")
	private WebElement linkAboutUs;
	
	@FindBy(id = "cartur")
	private WebElement linkCart;

	@FindBy(id = "login2")
	private WebElement linkLogIn;

	@FindBy(id = "signin2")
	private WebElement linkSingUp;

	@FindBy(id = "nameofuser")
	private WebElement linkNomeUser;

	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}

	public WebElement getLinkContact() {
		return linkContact;
	}

	public WebElement getLinkAboutUs() {
		return linkAboutUs;
	}

	public WebElement getLinkCart() {
		return linkCart;
	}

	public WebElement getLinkLogIn() {
		return linkLogIn;
	}

	public WebElement getLinkSingUp() {
		return linkSingUp;
	}

	public WebElement getLinkNomeUser() {
		return linkNomeUser;
	}
	
}
