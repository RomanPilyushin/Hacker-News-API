package org.example;

import lombok.Getter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
public class Post {

	private static final String HN_URL_PREFIX = "http://news.ycombinator.com/";
	private static final Pattern NUMBER_PATTERN = Pattern.compile("(\\d+).+");
	private static final Pattern TIME_AGO_PATTERN = Pattern.compile("(\\d+\\s[a-zA-Z]+\\sago)");

	private int rank;
	private int score;
	// Getters
	private int comments;
	private String title;
	private String url;
	private String user;
	private String userURL;
	private String commentsURL;
	private String timeAgo;

	// Setters
	public void setComments(String commentString) {
		Matcher m = NUMBER_PATTERN.matcher(commentString);
		if (m.find()) {
			this.comments = Integer.parseInt(m.group(1));
		}
	}

	public void setCommentsURL(String commentsURL) {
		this.commentsURL = HN_URL_PREFIX.concat(commentsURL);
	}

	public void setRank(String rankString) {
		this.rank = Integer.parseInt(rankString.replace(".", ""));
	}

	public void setScore(String scoreString) {
		Matcher m = NUMBER_PATTERN.matcher(scoreString);
		if (m.find()) {
			this.score = Integer.parseInt(m.group(1));
		}
	}

	public void setTimeAgo(String timeAgoString) {
		Matcher m = TIME_AGO_PATTERN.matcher(timeAgoString);
		if (m.find()) {
			this.timeAgo = m.group(1);
		}
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setUserURL(String userURL) {
		this.userURL = HN_URL_PREFIX.concat(userURL);
	}

	@Override
	public String toString() {
		return String.join("\t", Integer.toString(rank), title, url,
				Integer.toString(score), user, userURL,
				Integer.toString(comments), commentsURL, timeAgo);
	}
}