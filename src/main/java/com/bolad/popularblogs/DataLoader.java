package com.bolad.popularblogs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bolad.popularblogs.domain.Author;
import com.bolad.popularblogs.domain.Post;
import com.bolad.popularblogs.repository.AuthorRepository;
import com.bolad.popularblogs.repository.PostRepository;

@Component
public class DataLoader {
	
	private PostRepository postRepository;
	private AuthorRepository authorRepository;
	
	@Autowired
	public DataLoader(PostRepository postRepository, AuthorRepository authorRepository) {
		this.postRepository = postRepository;
		this.authorRepository = authorRepository;
	}
	
	@PostConstruct
	private void loadData() {
		postRepository.deleteAll();
		authorRepository.deleteAll();
		
		//create an author
		Author mz = new Author("Monika", "Zych", "monika.zych@gmail.com");
		authorRepository.save(mz);
		
		//create more authors
		createAuthors();
		
		//create some posts
		createPosts(mz);
	}

	private void createAuthors() {
		
		Author sa = new Author("Stanley", "Akyea", "stanley.akyea@gmial.com");	
		authorRepository.save(sa);
		
		Author ha = new Author("Henryk", "Akyea", "henryk.akyea@myspace.com");
		authorRepository.save(ha);
	}

	private void createPosts(Author author) {
		
		Date yesterday = null;
		
		try {
			yesterday = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a").parse("06/13/2018 10:55:45 PM");
		} catch(ParseException e){
			e.printStackTrace();
		}
		
		Post post = new Post("The Current State of HTTPS in 2018");
		
		post.setSlug("current state of HTTPS");
		
		post.setTeaser("It isn’t very often when people take SEO recommendations seriously. "
				+ "This is especially true when there aren’t any downright consequences for not "
				+ "following certain recommendations. In fact, it’s quite rare that people listen to these SEO recommendations at all…\n" + 
				"\n" + 
				"With that being said, it came as to no surprise when in 2014 Google established/confirmed HTTPS as a ranking mark. "
				+ "In short, Google was recommending for all websites to migrate to HTTPS for the mere sanctity of users’ security. "
				+ "However, just a few websites perceived this recommendation as a direct instruction and went on as usual.");
		
		post.setBody("For a few years after this research – the pace of the HTTPS adaptation was passive at best. However, Google was patient and continued sending out this recommendation in regards to the need of a more secure internet,  which included websites that users would input personal information.\n" + 
				"\n" + 
				"On September 2016 – Google decided to make yet a further announcement, which stated that at the beginning of January 2017, that they were going to be flagging all the non secured sites that were visited utilizing the Chrome browser.\n" + 
				"\n" + 
				"This latest announcement by Google basically meant that a warning would begin to appear on HTTP web pages in the following cases listed below:\n" + 
				"\n" + 
				"    If the website had credit card input fields or if users had to put password information.\n" + 
				"    If the website required any type of entry fields.\n" + 
				"    If the website was visited utilizing the Incognito mode.\n" + 
				"\n" + 
				"Keeping to their word – Google first implemented this warning in the form of a gray warning sign in Chrome’s address field. Once a user visited a site – they were prompted with the warning that the website was not secured. Google’s final step was taking the warning to its next level, which was to mark these messages/warnings in red.\n" + 
				"\n" + 
				"Needless to say, these warnings were much more obvious and harder to ignore. This warning was sending a concise message to users, which basically stated: “leave this website or you’ll be risking having personal information exposed publicly.”\n" + 
				"\n" + 
				"Surely, this had a rather catastrophic effect on websites’ reputations and their bounce rate.\n" + 
				"\n" + 
				"However, Google was not quite done… For over a year they had been conducting tests on a method that would mark unsecured websites right on the SERP. This new feature was put to use on several locations throughout The United States and had a grand backlash of on many websites. An immense amount of red flags went on unsecured website’s search snippets.");
		
		post.setPostedOn(yesterday);
		
		post.setKeywords(getHTTPkeywords());
		
	}

	private List<String> getHTTPkeywords() {
		List<String> keywords = new ArrayList<>();
		keywords.add("Google");
		keywords.add("research");
		return keywords;
	}
	
}
