package uk.RsaEncryption.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigInteger;

@Getter
@AllArgsConstructor
public class GenerationDetails {

    private BigInteger p;

    private BigInteger q;

    private BigInteger product;

    private BigInteger totient;

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
