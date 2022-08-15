package com.gft.formatting;

public class Format {

    public String formatNumberPhone(String telefone) {

        return telefone.replaceFirst("(\\d{2})(\\d{5})(\\d+)", "($1) $2-$3");
    }
}
