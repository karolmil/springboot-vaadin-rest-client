package com.example.springbootvaadinrestclient;

import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("cat")
public class CatFactGui extends HorizontalLayout {

    @Autowired
    public CatFactGui(CatFactClient catFactClient, CatGifClient catGifClient, CatGif2Client catGif2Client) {
        CatFact catFact = catFactClient.getCatFactFormApi();
        Label label = new Label(catFact.getText());
        //String catGif = catGifClient.getCatGifFormApi();
//        Image image = new Image(catGifClient.getCatGifFormApi(), "to jest obrazek z kotem");
        Image image2 = new Image(catGif2Client.getCatGifForm2Api(), "nie ma");

        add(label, image2);
    }

}
