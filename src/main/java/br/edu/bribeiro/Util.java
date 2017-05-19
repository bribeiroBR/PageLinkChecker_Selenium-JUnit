package br.edu.bribeiro;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

public class Util {

	private Actions actions;

	public Util(Actions actions) {
		this.actions = actions;
	}

	// List of All broken links of this page
	public List<WebElement> gettingBrokenForbiddenLinks(List<WebElement> pageLinks) throws Exception {
		List<WebElement> brokenLinksList = new ArrayList<WebElement>();

		for (WebElement element : pageLinks) {
			if (actions.isTheLinkBrokenForbidden(new URL(element.getAttribute("href")))) {
				brokenLinksList.add(element);
			}
		}
		return brokenLinksList;
	}

	// List of All broken links of this page
	public List<WebElement> gettingRedirectLinks(List<WebElement> pageLinks) throws Exception {
		List<WebElement> redirectLinksList = new ArrayList<WebElement>();

		for (WebElement element : pageLinks) {
			if (actions.isTheLinkRedirect(new URL(element.getAttribute("href")))) {
				redirectLinksList.add(element);
			}
		}
		return redirectLinksList;
	}

	// print all Elements found in the link list including the list size
	public void printLinkList(List<WebElement> linksList) {
		List<WebElement> myLinks = linksList;
		if (!myLinks.isEmpty()) {
			System.out.println(myLinks.size() + " links were found");
			for (int i = 0; i < myLinks.size(); i++) {
				System.out.println("Link = " + myLinks.get(i).getAttribute("href"));
			}
		} else {
			System.out.println("No link found for this search");
		}

	}

}