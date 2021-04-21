package by.bntu.fitr.poisit.vauczeckaja.lab1.model.logic.utils;


import by.bntu.fitr.poisit.vauczeckaja.lab1.model.entity.content.Content;

public class ContentCreator {
	public static Content[] createContent(int size) {
		Content[] contentList = new Content[size];
		for (int i  = 0; i < contentList.length; i++) {
			contentList[i] = new Content();
		}
		return contentList;
	}
}