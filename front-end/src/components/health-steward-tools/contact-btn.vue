<template>
  <q-btn flat rounded color="primary" :label="labelDisplay">
    <q-menu>
      <q-list dense style="min-width: 100px">
        <q-item clickable v-close-popup>
          <q-item-section>邮箱</q-item-section>
        </q-item>
        <q-separator />
        <q-item clickable>
          <q-item-section>移动电话</q-item-section>
          <q-item-section side>
            <q-icon name="keyboard_arrow_right" />
          </q-item-section>

          <q-menu anchor="top right" self="top left">
            <q-list>
              <q-item
                v-for="n in 3"
                :key="n"
                dense
                @click="selectLabel(val)"
                v-close-popup
              >
                <q-item-section>
                  {{ userName }}的电话号码: #{{ n }}
                </q-item-section>
              </q-item>
            </q-list>
          </q-menu>
        </q-item>
      </q-list>
    </q-menu>
  </q-btn>
</template>

<script>
export default {
  name: "ContactBtn",
  props: {
    userName: {
      type: String,
      required: true
    }
  },
  data() {
    return {
      labelDisplay: "联系方式"
    };
  },
  methods: {
    selectLabel(val) {
      this.labelDisplay = val;
    }
  }
};
</script>
