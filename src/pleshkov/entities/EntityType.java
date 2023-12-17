package pleshkov.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public enum EntityType {
    WOLF("\uD83D\uDC3A"),
    HORSE("\uD83D\uDC34"),
    SNAKE(""),
    FOX(""),
    DEER(""),
    SHEEP(""),
    BEAR(""),
    EAGLE(""),
    RABBIT(""),
    PLANT("\uD83C\uDF3F");


    public final String unicodeSymbol;

    EntityType(String unicodeSymbol) {
        this.unicodeSymbol = unicodeSymbol;
    }
}