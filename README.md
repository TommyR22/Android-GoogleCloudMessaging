Android-GoogleCloudMessaging
============================
This example create a Client app (Android) and a Server app (java) that communicate with Google Cloud Messaging service when the webcam of pc detect a motion.

##### Client App (GcmExample)
Based on this [guide](http://developer.android.com/google/gcm/index.html).Done with Eclipse.
"send" button for upstream message don't work with this server.


##### Server App (webcam)
Created with Java using [Jackson library](http://jackson.codehaus.org/) and [Sarxos library for webcam](https://github.com/sarxos/webcam-capture).


appcompat_v2_2 and google-play-service are the libraries that Client app needs.

## Setup
*Follow this [guide](http://developer.android.com/google/gcm/gs.html) to obtain the project id and api key.
*Insert the Project ID in MainActivity of Client App (String SENDER_ID).
*Insert API KEY in Motion.java of Server App (String apiKey).
*Open on your android device the Client app "GcmExample" to obtain RegID (can you see and copy it from Logcat).
*Add the RegID in Motion.java (c.addRegId(RegID)).Can you add other device for broadcast.
*Now you can run WebcamMain.java.

The code is commented for customizations and other things.


