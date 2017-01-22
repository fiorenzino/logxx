#!/usr/bin/env bash


java -Dvertx.logger-delegate-factory-class-name=io.vertx.core.logging.Log4j2LogDelegateFactory -Dlog4j.configurationFile=log4j2.xml -jar target/logxx-1.0-SNAPSHOT-fat.jar