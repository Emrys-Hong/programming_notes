FROM lssinh010.sin.sap.corp/nvidia/tensorflow:cuda8

ENV http_proxy=http://proxy.sin.sap.corp:8080
ENV HTTP_PROXY=http://proxy.sin.sap.corp:8080
ENV ftp_proxy=ftp://proxy.sin.sap.corp:8080
ENV FTP_PROXY=ftp://proxy.sin.sap.corp:8080
ENV https_proxy=https://proxy.sin.sap.corp:8080
ENV HTTPS_PROXY=https://proxy.sin.sap.corp:8080

RUN apt-get clean && rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*