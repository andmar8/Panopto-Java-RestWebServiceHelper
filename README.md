Panopto-Java-RestWebServiceHelper
=================================

This is a small library of helper objects used by the [RestWebservice](https://github.com/andmar8/Panopto-Java-RestWebService), it's main duty is to deserialize Panopto AXIS objects into absolutely vanilla POJO's found in the [SerializableObjects](https://github.com/andmar8/Panopto-Java-SerializableObjects) library, this is a pattern I've used before to good effect and allows a further abstraction layer for more reusability/extensibility, some may find it overkill however.

Requirements
------------

* [PanoptoSerializableObjects](https://github.com/andmar8/Panopto-Java-SerializableObjects) library
* [PanoptoAxis](https://github.com/andmar8/Panopto-Java-Axis) stubs library

How to compile
--------------

Follow the instructions for the respective required libraries to compile up their jars and then add them to the project like so (the names of the jars/libraries are as an example)...

1. PanoptoAxis1.6.2.jar
2. PanoptoSerializableObjects.jar

The code will now compile to a jar