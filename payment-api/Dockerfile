FROM node:7.3.0

RUN useradd --user-group --create-home --shell /bin/false app
ENV HOME=/home/app
USER app
WORKDIR $HOME

COPY src/app.js .
COPY src/package.json .
RUN npm install
CMD npm start

EXPOSE 9999
