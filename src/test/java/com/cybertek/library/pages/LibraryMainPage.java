package com.cybertek.library.pages;

import com.cybertek.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LibraryMainPage {

    public LibraryMainPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//span[.='Test Librarian 62']")
    public WebElement account;

    @FindBy(xpath = "//a[.='Log Out']")
    public WebElement logout;


    @FindBy(xpath = "//span[.='Dashboard']")
    public WebElement dashboard;

    @FindBy(xpath = "//h2[@id='user_count']")
    public WebElement countUsers;



}
