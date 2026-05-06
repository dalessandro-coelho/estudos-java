package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio;

public class ReportDto {
    private String aircrafName;
    private Country country;
    private Currency currency;
    private String personName;


    public static final class ReportDtoBuilder {
        private String aircrafName;
        private Country country;
        private Currency currency;
        private String personName;

        private ReportDtoBuilder() {
        }

        public static ReportDtoBuilder builder() {
            return new ReportDtoBuilder();
        }

        public ReportDtoBuilder aircrafName(String aircrafName) {
            this.aircrafName = aircrafName;
            return this;
        }

        public ReportDtoBuilder country(Country country) {
            this.country = country;
            return this;
        }

        public ReportDtoBuilder currency(Currency currency) {
            this.currency = currency;
            return this;
        }

        public ReportDtoBuilder personName(String personName) {
            this.personName = personName;
            return this;
        }

        public ReportDto build() {
            ReportDto reportDto = new ReportDto();
            reportDto.country = this.country;
            reportDto.currency = this.currency;
            reportDto.personName = this.personName;
            reportDto.aircrafName = this.aircrafName;
            return reportDto;
        }
    }

    @Override
    public String   toString() {
        return "ReportDto{" +
                "aircrafName='" + aircrafName + '\'' +
                ", country=" + country +
                ", currency=" + currency +
                ", personName='" + personName + '\'' +
                '}';
    }
}
