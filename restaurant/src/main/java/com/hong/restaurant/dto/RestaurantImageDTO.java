package com.hong.restaurant.dto;

import lombok.*;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class RestaurantImageDTO {

    private String uuid;
    private String imgName;
    private String path;

    public String getImageURL(){
        try{
            return URLEncoder.encode(path+"/"+uuid+"_"+imgName, "UTF-8");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

    public String getThumbnailURL(){
        try{
            return URLEncoder.encode(path+"/s_"+uuid+"_"+imgName, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }
}
