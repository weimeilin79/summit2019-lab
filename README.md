# Navigating Hybrid Cloud Integration - Hackathon

In the terminal run the following script to enable Camel K:

```
source ~/.bash_profile
```


To run the demo:

```
kamel run VehicleGenerator.java TrafficGenerator.java UserIntegration.java --dev --name routes -d camel-csv -d camel-kafka
```
