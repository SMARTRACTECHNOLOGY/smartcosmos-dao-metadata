package net.smartcosmos.dao.metadata;

import lombok.AllArgsConstructor;

/**
 * Enum of possible sort orders.
 */
@AllArgsConstructor
public enum SortOrder {
    ASC("asc"),
    DESC("desc");

    private final String sortOrder;

    /**
     * Gets the String value of a sort order.
     *
     * @return the sort order string
     */
    @Override
    public String toString() {

        return this.sortOrder;
    }

    /**
     * Gets the sort order enum entry for a String.
     *
     * @param sortOrderString the order string
     * @return the corresponding sort order or {@code ASC} if {@code sortOrderString} is invalid.
     */
    public static SortOrder fromString(String sortOrderString) {

        try {
            return valueOf(SortOrder.class, sortOrderString.toUpperCase());
        } catch (Exception e) {
            return ASC;
        }
    }
}
