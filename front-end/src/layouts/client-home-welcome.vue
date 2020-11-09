<template>
  <div>
    <!-- 主页海报 -->
    <div class="q-pa-md">
      <q-parallax>
        <template v-slot:media>
          <img src="https://cdn.quasar.dev/img/parallax2.jpg">
        </template>

        <template v-slot:content="scope">
          <div
            class="absolute column items-center"
            :style="{
              opacity: 0.45 + (1 - scope.percentScrolled) * 0.55,
              top: (scope.percentScrolled * 60) + '%',
              left: 0,
              right: 0
            }"
          >
            <!-- <img src="https://cdn.quasar.dev/logo/svg/quasar-logo.svg" style="width: 150px; height: 150px"> -->
            <div class="text-h3 text-white text-center">主页海报丫丫丫</div>

          </div>
        </template>
      </q-parallax>
    </div>

    <!-- 业务海报 1 -->
    <div class="q-pa-md">
      <q-parallax :height="200" :speed="0.5">
        <template v-slot:media>
          <img src="https://cdn.quasar.dev/img/parallax1.jpg">
        </template>

        <h1 class="text-white">业务海报 111</h1>
      </q-parallax>
    </div>

    <!-- 业务海报 2 -->
    <div class="q-pa-md">
      <q-parallax :height="200" :speed="0.5">
        <template v-slot:media>
          <img src="https://placeimg.com/500/300/nature">
        </template>

        <h1 class="text-white">业务海报 222</h1>
      </q-parallax>
    </div>

  </div>
</template>