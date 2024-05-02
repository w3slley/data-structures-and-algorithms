package main

import (
	"fmt"
	"strconv"
)

type Builder interface {
	withName(name string) PersonBuilder
	withAge(age int) PersonBuilder
	withLikesRunning(likesRunning bool) PersonBuilder
	build() Person
}

type Person struct {
	name         string
	age          int
	likesRunning bool
}

type PersonBuilder struct {
	person Person
}

func (p Person) greet() {
	likesRunning := ""
	if !p.likesRunning {
		likesRunning = " don't"
	}
	fmt.Println("Hey! I'm " + p.name + ", I have " + strconv.Itoa(p.age) + " years old and I" + likesRunning + " like running!")
}

// that means PersonBuilder implements withName of Builder interface
func (pb PersonBuilder) withName(name string) PersonBuilder {
	pb.person.name = name
	return pb
}

func (pb PersonBuilder) withAge(age int) PersonBuilder {
	pb.person.age = age
	return pb
}

func (pb PersonBuilder) withLikesRunning(likesRunning bool) PersonBuilder {
	pb.person.likesRunning = likesRunning
	return pb
}

func (pb PersonBuilder) build() Person {
	return pb.person
}

func main() {
	var personBuilder Builder = PersonBuilder{}
	person := personBuilder.withName("John").withAge(27).withLikesRunning(true).build()
	person.greet()

	person2 := Person{name: "Jane", age: 30, likesRunning: false}
	person2.greet()

	fmt.Println(person)
	fmt.Println(person2)
}
