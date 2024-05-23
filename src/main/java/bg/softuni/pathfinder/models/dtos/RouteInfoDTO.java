package bg.softuni.pathfinder.models.dtos;

public class RouteInfoDTO {
    private Long id;
    private String name;
    private String description;
    private String imageUrl;

    public RouteInfoDTO() {
    }

    public Long getId() {
        return id;
    }

    public RouteInfoDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public RouteInfoDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RouteInfoDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public RouteInfoDTO setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}
