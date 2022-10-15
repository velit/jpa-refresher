package fi.tapani.movie_service.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "movie")
public class Movie {

  @Id
  @GeneratedValue
  private UUID id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private int year;

  @Column
  private String synopsis;

  @Column
  private int ageLimit;

  @Column
  private int rating;

  @ElementCollection
  @CollectionTable(name = "movie_genres")
  private List<String> genres = new ArrayList<>();

  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,
      orphanRemoval = true)
  private List<Person> actors = new ArrayList<>();

  @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
  private Person director;

  public Movie() {
  }

  public Movie(String name, int year) {
    this.name = name;
    this.year = year;
  }

  public UUID getId() {
    return id;
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

  public List<String> getGenres() {
    return genres;
  }

  public void setGenres(List<String> genres) {
    this.genres = genres;
  }

  public List<Person> getActors() {
    return actors;
  }

  public void setActors(List<Person> actors) {
    this.actors = actors;
  }

  public Person getDirector() {
    return director;
  }

  public void setDirector(Person director) {
    this.director = director;
  }
}
