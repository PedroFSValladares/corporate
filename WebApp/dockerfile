FROM node:22.19-alpine AS build

WORKDIR /app

COPY package.json package-lock.json ./

RUN npm install

RUN npm install -g @angular/cli

COPY . .

RUN npm run build -- --configuration production

FROM nginx:1.29.1-alpine AS runtime

RUN rm -rf /usr/share/nginx/html/*

COPY --from=build /app/dist/app-front/browser /usr/share/nginx/html
COPY ./nginx.conf /etc/nginx/conf.d/default.conf

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]