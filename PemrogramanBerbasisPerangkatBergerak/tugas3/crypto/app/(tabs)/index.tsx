import { Image } from "expo-image";
import { Platform, StyleSheet } from "react-native";

import { HelloWave } from "@/components/hello-wave";
import ParallaxScrollView from "@/components/parallax-scroll-view";
import { ThemedText } from "@/components/themed-text";
import { ThemedView } from "@/components/themed-view";
import { Link } from "expo-router";
import { useEffect, useState } from "react";
import { Button } from "@react-navigation/elements";

export default function HomeScreen() {
  const [datacryto, setDatacryto] = useState([]);

  useEffect(() => {
    const url = "https://api.coinlore.net/api/tickers/";

    // example
    // {"data":[{"id":"90","symbol":"BTC","name":"Bitcoin","nameid":"bitcoin","rank":1,"price_usd":"91492.61","percent_change_24h":"0.95","percent_change_1h":"-0.29","percent_change_7d":"6.40","price_btc":"1.00","market_cap_usd":"1825236061954.00","volume24":39551743260.857254,"volume24a":44763507730.31366,"csupply":"19949546.00","tsupply":"19949546","msupply":"21000000"},{"id":"80","symbol":"ETH","name":"Ethereum","nameid":"ethereum","rank":2,"price_usd":"3037.37","percent_change_24h":"1.63","percent_change_1h":"-0.37","percent_change_7d":"7.70","price_btc":"0.033199","market_cap_usd":"366622528003.66","volume24":10323889937.423626,"volume24a":12621899717.242311,"csupply":"120703849.62","tsupply":"122375302","msupply":""},

    fetch(url)
      .then((response) => response.json())
      .then((data) => {
        setDatacryto(data.data);
      })
      .catch((error) => {
        console.error("Error fetching data:", error);
      });
  }, []);

  return (
    <ParallaxScrollView
      headerImage={
        <Image
          source={
            "https://images.unsplash.com/photo-1611974789855-9c2a0a7236a3?q=80&w=1470&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
          }
          style={{ width: "100%", height: "100%" }}
          contentFit="cover"
        />
      }
      headerBackgroundColor={{ light: "#f0f0f0", dark: "#181818" }}
    >
      {/* use table for list data crypto */}
      <ThemedView style={{ padding: 16 }}>
        <ThemedText style={{ marginBottom: 16 }}>
          Cryptocurrency Prices
        </ThemedText>

        <Button
          onPress={() => {
            const url = "https://api.coinlore.net/api/tickers/";
            fetch(url)
              .then((response) => response.json())
              .then((data) => {
                setDatacryto(data.data);
              })
              .catch((error) => {
                console.error("Error fetching data:", error);
              });
          }}
        >
          Refresh Data
        </Button>
        {datacryto.map((crypto: any) => (
          <ThemedView
            key={crypto.id}
            style={{
              flexDirection: "row",
              justifyContent: "space-between",
              paddingVertical: 8,
              borderBottomWidth: 1,
              borderBottomColor: "#ccc",
            }}
          >
            <ThemedText>#{crypto.rank}</ThemedText>
            <ThemedText>
              {crypto.name} ({crypto.symbol})
            </ThemedText>
            <ThemedText>${parseFloat(crypto.price_usd).toFixed(2)}</ThemedText>
          </ThemedView>
        ))}
      </ThemedView>
    </ParallaxScrollView>
  );
}

const styles = StyleSheet.create({
  titleContainer: {
    flexDirection: "row",
    alignItems: "center",
    gap: 8,
  },
  stepContainer: {
    gap: 8,
    marginBottom: 8,
  },
  reactLogo: {
    height: 178,
    width: 290,
    bottom: 0,
    left: 0,
    position: "absolute",
  },
});
