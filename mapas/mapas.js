var osmUrl = 'https://tile.openstreetmap.org/{z}/{x}/{y}.png',
                    osmAttrib = '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors',
                    osm = L.tileLayer(osmUrl, {maxZoom: 15, attribution: osmAttrib});

            var map = L.map('map').setView([-4.036, -79.201], 15);

            L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {
                attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
            }).addTo(map);L.marker([102.0,11.0]).addTo(map)
.bindPopup('Controlador.TDA.Grafos.Modelo.Escuela@324b61ff')´)
,.openPopup();
L.marker([-79.2015,-4.045]).addTo(map)
.bindPopup('Controlador.TDA.Grafos.Modelo.Escuela@3723bbf8')´)
,.openPopup();
