package uk.RsaEncryption.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class KeyPairEntity {

    private int publicKey;

    private int privateKey;

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
