FROM node:7.3.0

COPY src src/
WORKDIR src/

ARG ENVIRONMENT
ENV NODE_ENV ${ENVIRONMENT}
RUN npm install && npm install -g nodemon

CMD [ "npm", "start" ]
EXPOSE 9999
