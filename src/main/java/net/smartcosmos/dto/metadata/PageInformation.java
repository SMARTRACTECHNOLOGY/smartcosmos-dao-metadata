package net.smartcosmos.dto.metadata;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class PageInformation {
    // primitive types because of default values
    private final int size;
    private final long totalElements;
    private final int totalPages;
    private final int number;

    public PageInformation() {
        this.size = 0;
        this.totalElements = 0;
        this.totalPages = 0;
        this.number = 0;
    }
}
