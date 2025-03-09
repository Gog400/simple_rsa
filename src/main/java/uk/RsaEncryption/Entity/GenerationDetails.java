package uk.RsaEncryption.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GenerationDetails {

    private int p;

    private int q;

    private int product;

    private int totient;

    @Override
    public String toString() {
        return String.format("""
                generationDetails:
                        p:              %s,
                        q:              %s,
                        product:        %s,
                        totient:        %s
                """,
                p, q, product, totient);
    }

}
