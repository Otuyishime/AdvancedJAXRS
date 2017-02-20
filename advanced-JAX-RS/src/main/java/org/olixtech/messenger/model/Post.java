package org.olixtech.messenger.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Post {
	
	private long id;
	private Date created;
	private String author;
	
	private Map<Long, Comment> comments = new HashMap<Long,Comment>();
	// add links for HATEOS
	private List<Link> links = new ArrayList<Link>();
	
}
