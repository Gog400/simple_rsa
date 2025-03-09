package uk.RsaEncryption.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigInteger;

@Getter
@AllArgsConstructor
@Builder
public class KeyPairEntity {

    private BigInteger publicKey;

    private BigInteger privateKey;

    private GenerationDetails generationDetails;

    @Override
    public String toString() {
        return String.format("""
                Key Pair:
                    publicKey:          %s,
                    privateKey:         %s,
                    %s
                """,
                publicKey, privateKey, generationDetails);
    }
}
