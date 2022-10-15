package fi.tapani.movie_service.model;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movie")
public class Movie {

  @Id
  @GeneratedValue
  private UUID id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "year", nullable = false)
  private int year;

  @Column(name = "synopsis")
  private String synopsis;

  @Column(name = "ageLimit")
  private int ageLimit;

  @Column(name = "rating")
  private int rating;

  public Movie() {
  }

  public Movie(String name, int year) {
    this.name = name;
    this.year = year;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public String getSynopsis() {
    return synopsis;
  }

  public void setSynopsis(String synopsis) {
    this.synopsis = synopsis;
  }

  public int getAgeLimit() {
    return ageLimit;
  }

  public void setAgeLimit(int ageLimit) {
    this.ageLimit = ageLimit;
  }

  public int getRating() {
    return rating;
  }

  public void setRating(int rating) {
    this.rating = rating;
  }
}
