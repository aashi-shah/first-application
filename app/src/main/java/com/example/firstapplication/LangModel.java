package com.example.firstapplication;

public class LangModel {
    String lang;
    int imglang;

    public LangModel(String lang, int imglang) {
        this.lang = lang;
        this.imglang = imglang;

    }

// getter for imglang
    public int getImglang() {
        return imglang;
    }

    //setter for imglang
    public void setImglang(int imglang) {
        this.imglang = imglang;
    }

// getter for lang
    public String getLang() {
        return lang;
    }

    //setter for lang
    public void setLang(String lang) {
        this.lang = lang;
    }

}
