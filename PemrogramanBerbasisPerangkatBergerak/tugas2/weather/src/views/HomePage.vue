<template>
  <ion-page>
    <ion-header :translucent="true">
      <ion-toolbar>
        <ion-title>Weather App</ion-title>
      </ion-toolbar>
    </ion-header>

    <ion-content :fullscreen="true">
      <ion-refresher slot="fixed" @ionRefresh="refresh($event)">
        <ion-refresher-content></ion-refresher-content>
      </ion-refresher>

      <ion-header collapse="condense">
        <ion-toolbar>
          <ion-title size="large">Weather Data</ion-title>
        </ion-toolbar>
      </ion-header>

      <!-- <ion-list>
        <MessageListItem v-for="message in messages" :key="message.id" :message="message" />
      </ion-list> -->
      <ion-list>
        <WeatherListItem
          v-for="(weather, index) in weatherData"
          :key="index"
          :weather="weather"
        />
      </ion-list>
    </ion-content>
  </ion-page>
</template>

<script setup lang="ts">
import {
  IonContent,
  IonHeader,
  IonList,
  IonPage,
  IonRefresher,
  IonRefresherContent,
  IonTitle,
  IonToolbar,
} from "@ionic/vue";
import { getMessages, Message } from "@/data/messages";
import { onMounted, ref } from "vue";
import WeatherListItem from "@/components/WeatherListItem.vue";
import { getWeatherData, Weather } from "@/data/weather";

const weatherData = ref<Weather[]>([]);

onMounted(async () => {
  weatherData.value = await getWeatherData();
});

const refresh = (ev: CustomEvent) => {
  setTimeout(() => {
    ev.detail.complete();
  }, 3000);
};
</script>
