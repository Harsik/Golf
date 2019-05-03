<template>
  <div>
    <v-app>
      <v-navigation-drawer v-model='drawer' app>
        <v-list>
          <v-list-tile :to='item.to' :key='i' v-for='(item, i) in items' exact>
            <v-list-tile-action>
              <v-icon v-html='item.icon'></v-icon>
            </v-list-tile-action>

            <v-list-tile-content>
              <v-list-tile-title v-text='item.title'></v-list-tile-title>
            </v-list-tile-content>
          </v-list-tile>
        </v-list>
      </v-navigation-drawer>
      <v-toolbar app>
        <v-toolbar-side-icon @click.native.stop='drawer = !drawer'></v-toolbar-side-icon>
        <v-toolbar-title>Vuetify</v-toolbar-title>
        <v-spacer></v-spacer>

        <v-toolbar-items>
          <v-btn flat to='/login'>login</v-btn>
          <v-btn flat to='/signup'>Sign up</v-btn>
        </v-toolbar-items>
      </v-toolbar>
      <v-content>
        <v-container fluid class='pa-0' grid-list-md>
          <v-slide-y-transition mode='out-in'>
            <router-view></router-view>
          </v-slide-y-transition>
        </v-container>
      </v-content>
    </v-app>
  </div>
</template>

<script>
export default {
  name: 'App',
  components: {},
  data: () => ({
    drawer: false,
    items: [
      { icon: '3d_rotation', title: 'HelloWorld', to: '/' },
      { icon: 'accessibility', title: 'Alert', to: '/alert' },
      { icon: 'accessibility', title: 'Login', to: '/login' }
    ]
  })
}
</script>
