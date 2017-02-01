FROM node:7.3.0

RUN useradd --user-group --create-home --shell /bin/false app
ENV HOME=/home/app
USER app
WORKDIR $HOME

COPY src/package.json .
RUN npm install

COPY src/app.js .
CMD npm start

EXPOSE 9999
