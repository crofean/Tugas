<template>
  <ion-item>
    <ion-label>
      <h2
        style="
          width: 100%;
          align-items: center;
          display: flex;
          justify-content: space-between;
          padding: 20px;
        "
      >
        <ion-icon name="partly-sunny"></ion-icon>
        <div style="font-weight: normal">{{ weather.time }}</div>
        <span class="date">
          <ion-icon name="thermometer-outline"></ion-icon>
          <ion-note>{{ weather.temperature_2m }} °C</ion-note>
        </span>
      </h2>
    </ion-label>
  </ion-item>
</template>
<script setup lang="ts">
import { Weather } from "@/data/weather";
import { defineProps, onMounted } from "vue";

defineProps<{
  weather: {
    time: string;
    temperature_2m: number;
  };
}>();
</script>
<style scoped>
ion-item {
  --padding-start: 0;
  --inner-padding-end: 0;
}
ion-label {
  margin-top: 12px;
  margin-bottom: 12px;
}
h2 {
  font-weight: 600;
  margin: 0;
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
}
.date {
  align-items: center;
  display: flex;
}
ion-icon {
  color: #c9c9ca;
}
ion-note {
  margin-left: 4px;
}
</style>
