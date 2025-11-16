export interface Weather {
  time: string;
  temperature_2m: number;
}

export function getWeatherData(): Promise<Weather[]> {
  const API =
    "https://api.open-meteo.com/v1/forecast?latitude=-6.200000&longitude=106.816666&hourly=temperature_2m";
  const getWeather: Promise<Weather[]> = fetch(API)
    .then((response) => response.json())
    .then((data) => {
      const times: string[] = data.hourly.time;
      const temperatures: number[] = data.hourly.temperature_2m;
      const weatherData: Weather[] = times.map((time, index) => ({
        time: convertToHumanDate(time),
        temperature_2m: temperatures[index],
      }));
      return weatherData;
    })
    .catch((error) => {
      console.error("Error fetching weather data:", error);
      return [];
    });
  return getWeather;
}

function convertToHumanDate(isoString: string): string {
  const date = new Date(isoString);
  return date.toLocaleString("id-ID", {
    day: "2-digit",
    month: "long",
    year: "numeric",
    hour: "2-digit",
    minute: "2-digit",
  });
}
