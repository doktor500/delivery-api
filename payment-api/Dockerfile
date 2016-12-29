FROM node

EXPOSE 9999
COPY . /src
RUN cd /src; npm install
CMD ["nodejs", "/src/app.js"]
