package models

import com.fasterxml.jackson.annotation.{JsonCreator, JsonProperty}

@JsonCreator
case class Person @JsonCreator() (@JsonProperty("age") age: Int,
                   @JsonProperty("name") name: String,
                   @JsonProperty("gender") gender: String,
                   @JsonProperty("company") company: String,
                   @JsonProperty("email") email: String,
                   @JsonProperty("phone") phone: String,
                   @JsonProperty("address") address: String) extends Serializable
