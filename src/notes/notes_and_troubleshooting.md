# day 1
**Any** is similar to java Object but it can be 'primitive' as well

scala does not have **static methods** in a sense of a java static methods

**Imports** can be put even inside the methods

## [The Scala ternary operator syntax](https://alvinalexander.com/scala/scala-ternary-operator-syntax/)
In other programming languages there is a definite, unique **ternary operator** syntax, but in Scala, the ternary operator is just the normal Scala if/else syntax:
**if (i == 1) x else y**

## [yield](https://stackoverflow.com/questions/1052476/what-is-scalas-yield)

# day 2
Hint: Use 'object' keyword while creating a class if you're not sure whether you'll need more instances. Change it to class if you need more instances.

In scala you can redefine operators

scala has mutable and immutable collections
immutable are a bit slower

[this] - **strictly private**

## mixin
class Class1 extends Class2 with Trait1

## Package scope
package private
private[some.package.a.b.c]

### [Package Scope](https://alvinalexander.com/scala/how-to-control-scala-method-scope-object-private-package/)
To make a method available to all members of the current package — what would be called “package scope” in Java — mark the method as being private to the current package with the private[packageName] syntax.



