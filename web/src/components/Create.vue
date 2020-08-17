<template>
  <v-row justify="center">
    <v-dialog v-model="dialog" persistent max-width="600px">
      <template v-slot:activator="{ on }">
        <v-btn color="primary" dark text v-on="on">追加</v-btn>
      </template>
      <Modify :listId="listId" :add="true" :close="close" />
    </v-dialog>
  </v-row>
</template>

<script>
import Modify from "./Modify";
export default {
  name: "Create",
  props: { listId: Number },
  components: { Modify },
  data() {
    return {
      dialog: false,
    };
  },
  methods: {
    close() {
      this.dialog = false;
    },
  },
};
</script>
