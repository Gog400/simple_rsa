package uk.RsaEncryption;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EHashAlg {
    SHA_3_512("SHA3-512");

    private final String algName;
}
