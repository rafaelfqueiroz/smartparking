
# Smart Parking IoT - Solution

This is a documentation about an Internet of Things system for smart parking.

## Introduction

The Smart Parking IoT is a system that proposes a solution for parkings. 
Its aim is designate a free parking lot for a car comming. The Smart Parking 
IoT sends the chosen parking lot to the car driver smartphone and opens the gate.
Thus, the driver can go directly to the parking lot designated for him.

## Web Service

This section describes how you can make HTTP requests for the web service.
When a car comes, its necessary notificate the web service. 
It can be done sending a post request as described bellow:

```
 $ post http://[host]/entrance/car
```
The body of the request must be:
```
 { 
	tagValue : "String value"
 }
```

The response is the free parking lot chosen.

To send a request for notificating the change of parking lot state, just post request like bellow:
```
$ post http://[host]/parking/occupy
```
The body of the request must be:
```
 {
	number : Integer,
	state  : Boolean
 }
```

See documentation .adoc file at
[full documentation](https://github.com/rafaelfqueiroz/smartparking/tree/master/docs/html5)



