FROM node:latest as build
WORKDIR /usr/local/src/app
COPY . .
RUN npm install -g @angular/cli
RUN npm run build

FROM nginx:latest
COPY --from=build /usr/local/src/app/nginx.conf /etc/nginx/nginx.conf
COPY --from=build /usr/local/src/app/dist/i-tender/ /usr/share/nginx/html
EXPOSE 80